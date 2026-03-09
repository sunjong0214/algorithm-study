T = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def can_connect(x, y, d):
    nx, ny = x + dx[d], y + dy[d]

    while 0 <= nx < N and 0 <= ny < N:
        if arr[nx][ny] != 0:  # 코어나 전선 있으면 불가
            return False
        nx += dx[d]
        ny += dy[d]

    return True


def set_line(x, y, d, value):
    nx, ny = x + dx[d], y + dy[d]
    cnt = 0

    while 0 <= nx < N and 0 <= ny < N:
        arr[nx][ny] = value
        cnt += 1
        nx += dx[d]
        ny += dy[d]

    return cnt


def dfs(idx, connected, length):
    global best_core, best_len

    # 가지치기
    remain = len(cores) - idx
    if connected + remain < best_core:
        return

    if idx == len(cores):
        if connected > best_core:
            best_core = connected
            best_len = length
        elif connected == best_core:
            best_len = min(best_len, length)
        return

    x, y = cores[idx]

    connected_any = False
    for d in range(4):
        if can_connect(x, y, d):
            connected_any = True
            l = set_line(x, y, d, 2)
            dfs(idx + 1, connected + 1, length + l)
            set_line(x, y, d, 0)

    # 이 코어를 연결 안 하는 경우
    dfs(idx + 1, connected, length)


for tc in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    cores = []
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 1:
                # 가장자리는 이미 연결된 코어라 제외
                if i == 0 or i == N - 1 or j == 0 or j == N - 1:
                    continue
                cores.append((i, j))

    best_core = -1
    best_len = float('inf')

    dfs(0, 0, 0)

    print(f'#{tc} {best_len}')
