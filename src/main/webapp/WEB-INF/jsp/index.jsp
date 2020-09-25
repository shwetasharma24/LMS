<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>LMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">LMS</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">All Books</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/newBook">New Book</a>
    </li>
  </ul>
</nav>

<div class="container">
  <c:choose>
     <c:when test="${mode=='BOOK_VIEW'}">
        <table class="table table-bordered">
            <thead>
              <tr>
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Purchase Date</th>
                <th>Edit</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="book" items="${books}">
                <tr>
                  <td>${book.id}</td>
                  <td>${book.bookName}</td>
                  <td>${book.authorName}</td>
                  <td>${book.purchaseDate}</td>
                  <td><a href="updateBook?id=${book.id}">
                    <svg class="bi bi-pencil" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                      <path fill-rule="evenodd" d="M11.293 1.293a1 1 0 011.414 0l2 2a1 1 0 010 1.414l-9 9a1 1 0 01-.39.242l-3 1a1 1 0 01-1.266-1.265l1-3a1 1 0 01.242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z" clip-rule="evenodd"/>
                      <path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 00.5.5H4v.5a.5.5 0 00.5.5H5v.5a.5.5 0 00.5.5H6v-1.5a.5.5 0 00-.5-.5H5v-.5a.5.5 0 00-.5-.5H3z" clip-rule="evenodd"/>
                    </svg>
                  </a></td>
                </tr>
             </c:forEach>
            </tbody>
           </table>
         </c:when>

         <c:when test="${mode=='BOOK_EDIT' || mode=='NEW_BOOK'}">
             <form action="save" method="POST">
                <div class="form-group">
                  <label for="id">Book ID:</label>
                  <input type="text" class="form-control" id="id" value="${book.id}" name="id">
                  </div>
                <div class="form-group">
                  <label for="bookName">Book Name:</label>
                  <input type="text" class="form-control" id="bookName" value="${book.bookName}" placeholder="Enter book's name" name="bookName">
                </div>
                <div class="form-group">
                  <label for="authorName">Author:</label>
                  <input type="text" class="form-control" id="authorName" value="${book.authorName}" placeholder="Enter author's name" name="authorName">
                </div>
                <div class="form-group">
                  <label for="purchaseDate">Purchase Date:</label>
                  <input type="Date" class="form-control" id="purchaseDate" value="${book.purchaseDate}" placeholder="yyyy-mm-dd" name="purchaseDate">
                 </div>
                <button type="submit" class="btn btn-default">Submit</button>
              </form>
         </c:when>
   </c:choose>
</div>
</body>
</html>