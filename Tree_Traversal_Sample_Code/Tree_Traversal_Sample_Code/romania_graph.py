
# Demo code for CSCI 111 (Intro to AI)
# Topic:  problem solving and search
#
# getgraph(): returns the adjacency list and distance matrix
#             of the Romania routing problem instance.
#             adj[city] returns a list of all cities aadjacent to city.
#             dist[city1,city2] returns the distance between two cities.

def getgraph():
    adj = {}
    dist = {}
    adj['Oradea'] = ['Sibiu', 'Zerind']
    dist['Oradea,Zerind'] = 71
    dist['Oradea,Sibiu'] = 151
    adj['Zerind'] = ['Arad','Oradea']
    dist['Zerind,Arad'] = 75
    dist['Zerind,Oradea'] = 71
    adj['Arad'] = ['Sibiu','Timisoara','Zerind']
    dist['Arad,Sibiu'] = 140
    dist['Arad,Timisoara'] = 118
    dist['Arad,Zerind'] = 75
    adj['Timisoara'] = ['Arad','Lugoj']
    dist['Timisoara,Arad'] = 118
    dist['Timisoara,Lugoj'] = 111
    adj['Lugoj'] = ['Mehadia','Timisoara'] 
    dist['Lugoj,Mehadia'] = 70
    dist['Lugoj,Timisoara'] = 111
    adj['Mehadia'] = ['Drobeta','Lugoj']
    dist['Mehadia,Drobeta'] = 75
    dist['Mehadia,Lugoj'] = 70
    adj['Drobeta'] = ['Craiova','Mehadia']
    dist['Drobeta,Craiova'] = 120
    dist['Drobeta,Mehadia'] = 75
    adj['Craiova'] = ['Drobeta','Pitesti','Rimnicu']
    dist['Craiova,Drobeta'] = 120
    dist['Craiova,Pitesti'] = 138
    dist['Craiova,Rimnicu'] = 146
    adj['Rimnicu'] = ['Craiova','Pitesti','Sibiu']
    dist['Rimnicu,Craiova'] = 146
    dist['Rimnicu,Pitesti'] = 97
    dist['Rimnicu,Sibiu'] = 80
    adj['Sibiu'] = ['Arad','Fagaras','Oradea','Rimnicu']
    dist['Sibiu,Arad'] = 140
    dist['Sibiu,Fagaras'] = 99
    dist['Sibiu,Oradea'] = 151
    dist['Sibiu,Rimnicu'] = 80
    adj['Fagaras'] = ['Bucharest','Sibiu']
    dist['Fagaras,Bucharest'] = 211
    dist['Fagaras,Sibiu'] = 99
    adj['Pitesti'] = ['Bucharest','Craiova','Rimnicu']
    dist['Pitesti,Bucharest'] = 101
    dist['Pitesti,Craiova'] = 138
    dist['Pitesti,Rimnicu'] = 97
    adj['Bucharest'] = ['Fagaras','Giurgiu','Pitesti','Urziceni']
    dist['Bucharest,Fagaras'] = 211
    dist['Bucharest,Giurgiu'] = 90
    dist['Bucharest,Pitesti'] = 101
    dist['Bucharest,Urziceni'] = 85
    adj['Giurgiu'] = ['Bucharest']
    dist['Giurgiu,Bucharest'] = 90
    adj['Urziceni'] = ['Bucharest','Hirsova','Vaslui']
    dist['Urziceni,Bucharest'] = 85
    dist['Urziceni,Hirsova'] = 98
    dist['Urziceni,Vaslui'] = 142
    adj['Vaslui'] = ['Iasi','Urziceni']
    dist['Vaslui,Iasi'] = 92
    dist['Vaslui,Urziceni'] = 142
    adj['Iasi'] = ['Neamt','Vaslui']
    dist['Iasi,Neamt'] = 87
    dist['Iasi,Vaslui'] = 92
    adj['Neamt'] = ['Iasi']
    dist['Neamt,Iasi'] = 87
    adj['Hirsova'] = ['Eforie','Urziceni']
    dist['Hirsova,Eforie'] = 86
    dist['Hirsova,Urziceni'] = 98
    adj['Eforie'] = ['Hirsova']
    dist['Eforie,Hirsova'] = 86
    return adj,dist
