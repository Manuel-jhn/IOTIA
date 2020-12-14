import numpy as np

x_entrer = np.array(([6, 2], [5, 7], [6, 1], [5, 7], [7,5], [6, 4], [6, 4], [2, 6], [6 , 5]), dtype=int) # données d'entrée
y = np.array(([1], [0], [1],[0],[1],[0],[1],[0]), dtype=int) # données de sortie /  1 = victoire /  0 = défaite

x_entrer = x_entrer/np.amax(x_entrer, axis=0) # on divise par la plus grande valeur de la ligne pour tout ramener sur [0,1]

X = np.split(x_entrer, [8])[0] #recupere les entrees dont la sortie est connue
xPrediction = np.split(x_entrer,[8])[1] #recupere l'entree dont la sortie est inconnue

class Neural_Network(object):
    def __init__(self):
        self.inputSize = 2 #2 entrees
        self.outputSize = 1 #1 sortie
        self.hiddenSize = 3 #3 neurones caches

        self.W1 = np.random.randn(self.inputSize, self.hiddenSize) #cree le poids des synapses entre entrees et caches 2x3
        self.W2 = np.random.randn(self.hiddenSize, self.outputSize) #cree le poids des synapses entre caches et sortie 3x1

    def forward(self,X): #fonction qui passe à travers le reseau de neurones
        self.z = np.dot(X, self.W1)
        self.z2 = self.sigmoid(self.z)
        self.z3 = np.dot(self.z2, self.W2)
        o = self.sigmoid(self.z3)
        return o

    def sigmoid(self,s):
        return 1/(1+np.exp(-s))

    def sigmoidPrime(self,s):
        return s * (1-s)

    #Fonction de retropropagation, met à jour son poids pour corriger l'erreur
    def backward(self, X, y, o): #X valeur d'entrée, y valeur attendue, o valeur de sortie
        #Calcul le delta de l'erreur de sortie
        self.o_error = y - o
        self.o_delta = self.o_error * self.sigmoidPrime(o)

        #Calcul le delta de l'erreur de la couche cachée
        self.z2_error = self.o_delta.dot(self.W2.T)
        self.z2_delta = self.z2_error * self.sigmoidPrime(self.z2)

        #Mise à jour des poids
        self.W1 += X.T.dot(self.z2_delta)
        self.W2 += self.z2.T.dot(self.o_delta)

    #entraine le programme
    def train(self, X, y):
        o = self.forward(X)
        self.backward(X,y,o)

    def predict(self):
        print("Donnée prédite après entrainement: ")
        print("Entrée : \n"+ str(xPrediction))
        print("Sortie : \n"+ str(self.forward(xPrediction)))
        self.chanceVictoire = (self.forward(xPrediction)[0][0])*100
        if(self.forward(xPrediction) > 0.5):
            print("L'algorithme pense que le joueur va gagner à  %.2f pourcent \n" % self.chanceVictoire)
        else:
            print("L'algorithme pense que le joueur va perdre à  %.2f pourcent \n" % (1-self.chanceVictoire))


NN = Neural_Network()

for i in range(30000):
    print("# "+str(i)+"\n")
    print("Valeur d'entrées : \n" + str(X))
    print("Sortie actuelle : \n" + str(y))
    print("Sorie predite : \n" + str(np.matrix.round(NN.forward(X), 2)))
    print("\n")
    NN.train(X,y)

NN.predict()
