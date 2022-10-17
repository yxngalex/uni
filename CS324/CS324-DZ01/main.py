    from math import log2, ceil, floor

    num = int(input("Enter a number"))

    print("Number is power of 2" if ceil(log2(num)) == floor(log2(num)) else "Number is not a power of 2")
