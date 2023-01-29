def main():
    while True:
        try:
            inp = input("Unesite neki broj: ")

            if not inp:
                print("Izlaz iz programa")
                exit()

            count = 0.0

            for i in range(0, len(inp)):
                count += float(inp[i])

            print(count)

        except ValueError:
            print("Pogresan unos!")


if __name__ == '__main__':
    main()
