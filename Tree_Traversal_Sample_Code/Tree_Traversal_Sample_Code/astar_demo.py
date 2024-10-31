
# Program that simulates node expansion and search using A* search
#
# The Romania dataset in the Russel-Norvig textbook is used
#    requires romaniagraph.py which sets up the graph from the example
#         and dist_bucharest.py which stores the straight-line distances
#
# Priority queue used stores cost, city, and path (and priority)

from queue import PriorityQueue
from romania_graph import getgraph
from dist_bucharest import straightlinetoBuch

def solveastar(adj,dist,metric,source,dest):
    pq = PriorityQueue()
    # add initial state to priority queue
    pq.put((metric[source],(0,source,source)))
    reached = {}
    while (pq.qsize() > 0):
        (prio,(cost,city,path)) = pq.get()
        print(prio,cost,city,path)
        if city == dest:
            return cost,path
        # get children
        for c in adj[city]:
            ix = city+","+c
            weight = dist[ix]
            val = cost+weight
            if (reached.get(c) is None): # if not yet reached
                # print(c,val)
                pq.put((val+metric[c],(val,c,path+'-'+c)))
                reached[c] = val
            else:
                if (val < reached[c]): # if reached and improvement found
                    pq.put((val+metric[c],(val,c,path+'-'+c)))
                    reached[c] = val

adj, dist = getgraph()
straight = straightlinetoBuch()
source = 'Arad'
dest = 'Bucharest'

source = 'Arad'
dest = 'Bucharest'

print('Source:',source)
print('Destination:',dest)
print()
print('A* Search')
ans,path = solveastar(adj,dist,straight,source,dest)
print()
print('A* Search returns:'+str(ans)+','+path)
