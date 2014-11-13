1.) The controllerClass setsup its constructor to build a gui containter two buttons and a text field.
2.)within its constructor,it calls the toolBarinter. setTextPanel(textPanelinter); from the ToolBarinter();
3.)The toolbarinter class is defined to handle communications for the buttons,it extends a JButton class and inplements an actionListener() interface.
    It contains two methods
    i)The setTextPanel() 
    ii.)The Action perfermed method is implemented from the actionListener interface.inside this method a call was made to getsource()This returns the object that performed the object.  
4.)The TextPanelInter class extends the jpanel class,it handles the communication that has to do with the textarea.It has appendtext method that calls the append method for a textarea object.
5.)The toolbarinter2 class runs defines a more profession and safe way to handle communication between the controller and components 
class.
6.Class FormPanelInter designs a form page and explains how to space and organise components within a panel,especially 
when they need to follow a pattern,it uses the gridbaglayout.