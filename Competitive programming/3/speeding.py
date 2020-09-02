max_velocity = 0
time_vel = []
n = int(input())
for i in range(n):
    time, distance = map(int, input().split())
    time_vel.append([time, distance])

for i in range(n-1):
    time1 = time_vel[i + 1][0] - time_vel[i][0]
    dist1 = time_vel[i + 1][1] - time_vel[i][1]

    velocity = dist1//time1

    if velocity > max_velocity:
        max_velocity = velocity

print(max_velocity)