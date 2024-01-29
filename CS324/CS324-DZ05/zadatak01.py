class Document:
    def __init__(self, name, num_words):
        self.name = name
        self.num_words = num_words


class Book(Document):
    current_num = 1

    def __init__(self, name, num_words, author, genre, year):
        super(Book, self).__init__(name, num_words)
        self.key = "lib{}".format(str(self.current_num).rjust(3, "0"))
        self.author = author
        self.genre = genre
        self.year = year
        Book.current_num += 1

    def __repr__(self):
        return "{}: '{}', '{}', '{}.' \n".format(self.key, self.author, self.genre, self.name)


def main():
    books = [
        Book("Game of Thrones", 5000, "George R. R. Martin", "Drama", 1996),
        Book("The Witcher", 2500, "Andrzej Sapkowski", "Novel", 1993),
        Book("Thus Spoke Zarathustra", 63500, "Friedrich Nietzsche", "Poetry", 1883),
        Book("The Lord of the Rings", 100, "J.R.R Tolkien", "Adventure", 1955),
        Book("Harry Potter", 150, "J.K. Rowling", "Drama", 1997),
        Book("The Wizard of Oz", 250, "L. Frank Baum", "Fantasy", 1900),
        Book("To Kill a Mockingbird", 100, "Harper Lee", "Action", 1960),
        Book("The Great Gatsby", 100, "F. Scott Fitzgerald", "Novel", 1925),
        Book("Hamlet", 5000, "William Shakespear", "Tragedy", 1602),
        Book("Francis of the Filth", 420, "George Miller", "Novel", 1990)
    ]

    dirs = {book.key: book for book in books}

    print(dirs)


if __name__ == "__main__":
    main()
