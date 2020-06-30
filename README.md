How to run tests?

1) Open IntelliJ idea
2) Select appropriate class
3) Select Run from context menu

Test Cases

1. Work of filtration for existing item after selecting from popular tag
  
  1) Open website
  2) Select tag from the popular tags list
    a) Tag should become focused
    b) All content of page after the filtration should contain appropriate tag
    c) Tag should be shown as selected at the navigation label

2. Cancelling filtration after clickng to global feed

  1) Open website
  2) Select tag from the popular tags list
  3) Click to the global feed at the navigation panel 
    a) Tag should be removed from navigation
    b) Tag should be unselected at the popular tags

3. Filtration cancelling after page reloading 

  1) Open website
  2) Select tag from the popular tags list
  3) Refresh page 
    a) Tag should be removed from navigation
    b) Tag should be unselected at the popular tags

4. Filtration of new articles

  1) Create new article with one of the popular tags
  2) Open the main page
  3) Select appropriate tag
    a) Created article should be on the first page
    b) Created article should contain appropriate tag
