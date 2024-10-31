
# Program that simulates node expansion and search using uniform-cost search
#
# The Romania dataset in the Russel-Norvig textbook is used
#    requires romaniagraph.py which sets up the graph from the example
#
# Priority queue used stores cost, city, and path (priority = cost)

from queue import PriorityQueue
from romania_graph import getgraph

def solveucs(adj,dist,source,dest):
    pq = PriorityQueue()
    # add initial state to priority queue
    pq.put((0,(source,source)))
    reached = {}
    reached[source] = 0
    while (pq.qsize() > 0):
        (cost,(city,path)) = pq.get()
        print(cost,city,path)
        if city == dest:
            return cost,path
        # get children
        for c in adj[city]:
            ix = city+","+c
            weight = dist[ix]
            val = cost+weight
            if (reached.get(c) is None): # if not yet reached
                # print(c,val)
                pq.put((val,(c,path+'-'+c)))
                reached[c] = val
            else:
                if (val < reached[c]): # if reached and cost to city improves
                    # print(c,val)
                    pq.put((val,(c,path+'-'+c)))
                    reached[c] = val

adj, dist = getgraph()
source = 'Arad'
dest = 'Bucharest'

print('Source:',source)
print('Destination:',dest)
print()
print('Uniform-Cost Search')
ans,path = solveucs(adj,dist,source,dest)
print()
print('UCS returns:'+str(ans)+','+path)

