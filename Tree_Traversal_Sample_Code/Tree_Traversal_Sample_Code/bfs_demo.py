
# Program that simulates node expansion and breadth-first search
#
# The Romania dataset in the Russel-Norvig textbook is used
#    requires romania_graph.py which sets up the graph from the example

from romania_graph import getgraph

def solvebfs(adj,dist,source,dest):
    if source == dest:
        return (0,source)
    # add initial state to FIFO queue
    frontier = [(0,source,source)]
    reached = [source]
    while len(frontier) > 0:
        (cost,city,path) = frontier.pop(0)
        print(cost,city,path)
        # get children
        for c in adj[city]:
            ix = city+","+c
            newcost = cost+dist[ix]
            if (c == dest):
                return (newcost,path+'-'+c)
            if (c not in reached): # if not yet reached
                frontier.append((newcost,c,path+'-'+c))
                reached.append(c)

adj, dist = getgraph()
source = 'Arad'
dest = 'Bucharest'

print('Source:',source)
print('Destination:',dest)
print()
print('Breadth-First Search')
ans,path = solvebfs(adj,dist,source,dest)
print()
print('BFS returns:'+str(ans)+','+path)
