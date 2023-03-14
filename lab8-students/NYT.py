def create_books_2Dlist(file_name):
    #file_name=input("Enter the name of the file: ")
    file_name=file_name.strip()
    nyt = open(file_name).read().splitlines()

    table = []
    
    #nyt = nyt.split("    ")
    for book in nyt:
        book = book.split("    ")
        print(book)
        book[0]=book[0].split("\t")
        
        for i in range(0,len(book)):
       
            date = book[i][0]
            title = book[i][1]
            author = book[i][2]
            publisher = book[i][3]
            category = book[i][4]
    
        table.append([date,title,author,publisher,category])
    print(table)


# file_name=input("Enter the name of the file: ")
# file_name=file_name.strip()
# table = create_books_2Dlist("NYT_short.txt")
print(create_books_2Dlist("NYT_short.txt"))