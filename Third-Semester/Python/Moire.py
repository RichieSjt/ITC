import matplotlib.pyplot as plt
import numpy as np
import math

#Limits of the graph
ax = plt.gca()
ax.set_xlim((-100, 100))
ax.set_ylim((-100, 100))

#Graph of the level curves from the function x^2 + y^2 = (mp)^2
i = 1
while(i<=14):
    circle = plt.Circle((0, 0), (i*5), fill = False)
    ax.add_artist(circle)
    i += 0.5

#Graph of the level curves from the function y = n(lambda * p)
#lambda = 1.2 to observe ellipses
#lambda = 0.9 to observe hyperbolas
i = -44
while(i<=44):
    y = i*(0.9 * 5)
    line = plt.hlines(y, -150, 150)
    i += 0.5


plt.xlabel('x axis')
plt.ylabel('y axis')
plt.grid(alpha=.4,linestyle='--')
plt.show()
