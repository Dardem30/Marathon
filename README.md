# Marathon
In the main package we have only two classes.
First class is AnalyzerTextService. This class has two methods for checking.
Method analyzer() returns list with 10 words which most common in text . 
Second method is check().It returns "correct" or "incorrect" , it's depend on position of brackets.
Second class is MainController.
It has two method-handler and one method for support. Let's begining from last. 
Method for support is load(). It load file on server.We must give it Multipart file for load.
Methods-handlers are checkBrackets() and checkWords(). The first method checks brackets ,the second method checks most common words. 
They have common url-pattern ("/check") and the same method POST, but each has own params.
Settings and view are located in the package web. We have only one view.In this view we have a form. 
This form has two action with different params and has one field for file and two button . 
Beside form we have table and one variable.The variable reporteds about correct/incorrect position of brackets.
The table returns 10 most common words in text.
