
# Program that simulates node expansion and depth-first search
# (with repeated state detection)
#
# The Romania dataset in the Russel-Norvig textbook is used
#    requires romania_graph.py which sets up the graph from the example

from romania_graph import getgraph

def solvedfs(adj,dist,source,dest):
    # add initial state to LIFO queue
    frontier = [(0,source,source)]
    reached = []
    while len(frontier) > 0:
        (cost,city,path) = frontier.pop()
        print(cost,city,path)
        if (city == dest):
            return (cost,path)
        reached.append(city)
        # get children
        for c in adj[city]:
            ix = city+","+c
            newcost = cost+dist[ix]
            if (c not in reached): # if not yet reached
                frontier.append((newcost,c,path+'-'+c))

adj, dist = getgraph()
source = 'Arad'
dest = 'Bucharest'

print('Source:',source)
print('Destination:',dest)
print()
print('Depth-First Search')
ans,path = solvedfs(adj,dist,source,dest)
print()
print('DFS returns:'+str(ans)+','+path)
