#Andrino

... is an interactive Javascript interpreter. It functions by embedding [Mozilla's Rhino]
(https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino) implementation of Javascript.

One reason that Johnny can't program is
because the kids today cannot find a simple interactive programming environment to get started
with. **Andrino** is my humble attempt to address this problem. It is a great way to practice
beginning programming with Javascript. Never again will your kids need to fight for nought on
long road trips. Now you can give them something worthy of conflict.

##RTFM

The general drill with Andrino is that you type something into the box at the bottom of the screen,
and Andrino will respond. What you type and Andrino's responses are all displayed in the interaction log above.

If you enter Javascript commands such as "a=5", then Andrino will evaluate the command and print
a result. Try that now and see what happens.

Andrino remembers what you typed earlier and will give that due consideration in its evaluation
efforts. So for example, if you now enter "b = a + 10" Andrino will respond "15.0" because it
remembers the prior value of a.

You can also enter function definitions and use them later. So for example, if you enter
"function f(x) {return x*10}" and then later enter "f(5)" Andrino will respond "50.0"

Your expressions will eventually outgrow the small text entry box. When that happens, be sure to
click the button labled "Full Screen Editor", to make use of a full screen text editor.

If you click on any of the entries in the interaction log that entry will be copied into the full
 screen editor for your convenience. You may find this useful for correcting errors in large expressions.

##A More Interesting Example

Try this (even at home!):

    function factorial(x) {
        if(x>1)
	        return x*factorial(x-1)
	    return 1
    }

    factorial(20)

##Limitations

Andrino is a simple tool that will enable you to do some simple things. It is limited in the following ways:

* There is presently no capacity to save or retrieve files.

* It only knows Javascript, but nothing about HTML or DOM models.

* The text editor is a simple and humble thing. No line numbers, syntax checking, auto completion or anything fancy.

