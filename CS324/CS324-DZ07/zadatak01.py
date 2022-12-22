import re


def main():
    index = 4173
    last_num = str(index)[-1]
    with open("data.txt", "r") as file, open("adrese.txt", "w") as to:
        content = file.read()
        pattern = re.compile(r"^{}\d+\s.*".format(last_num), re.MULTILINE)
        for addr in re.findall(pattern, content):
            to.write(addr + "\n")


if __name__ == '__main__':
    main()
