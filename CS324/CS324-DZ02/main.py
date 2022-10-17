def is_prime(num):
    if num >= 1:
        for i in range(2, num):
            if num % i == 0:
                return False

        return True


def main():
    for n in range(200):
        if is_prime(n):
            print(n)


if __name__ == '__main__':
    main()
