## How to make java only (no Android) unit testing work
http://tools.android.com/tech-docs/unit-testing-support
http://tools.android.com/tech-docs/new-build-system/user-guide#TOC-Testing

##Icons
http://www.iconspedia.com/pack/weby-icons-1884/30.html

##Rhino
http://mozilla.github.io/rhino/javadoc/index.html

##Serialization of Rhino Objects
The objects that Rhino uses to function must survive the gyrations of the activity
lifecycle.  There are several possible options for doing this.

1. Store these objects in the Application object.  This is the easiest choice and the
presently selected method.

2. Figure out how Rhino "continuations" work.  This has proven to be much more difficult
that I hoped and I have set this method aside for now.

For a good time, check out the
following links for info about how to do this with Rhino, including some UnitTest code
that easily compiles and executes in this project.

http://marijnhaverbeke.nl/cps/
http://matt.might.net/articles/by-example-continuation-passing-style/
http://matt.might.net/articles/programming-with-continuations--exceptions-backtracking-search-threads-generators-coroutines/
http://blog.norrisboyd.com/
https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/New_in_Rhino_1.7R2
http://mxr.mozilla.org/mozilla/source/js/rhino/testsrc/org/mozilla/javascript/tests/ContinuationsApiTest.java

