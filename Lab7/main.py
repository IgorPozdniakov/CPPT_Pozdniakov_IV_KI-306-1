nRows = int(input("Введіть значення матриці: "))
filler = input("Введіть символ для заповнення: ")

with open("MyFile.txt", "w") as fout:
    if nRows % 2 == 1:
        print("Непарне значення матриці!")
    else:
        nMid = nRows // 2
        arr = [[' ' for _ in range(nRows)] for _ in range(nMid)]

        if len(filler) > 1:
            print("Забагато символів!")
        elif len(filler) == 0:
            print("Замало символів!")
        else:
            k = -1
            for i in range(nMid):
                for j in range(nRows):
                    arr[i][j] = filler

            for i in range(nRows):
                for j in range(nRows):
                    if i % 2 == 0:
                        print(" ", end="")
                        fout.write(" ")
                    else:
                        print(arr[i - k][j], end="")
                        fout.write(arr[i - k][j])

                print()
                fout.write("\n")
                k += 1