# [HelloUpdateLoop](https://wiki.jmonkeyengine.org/docs/3.3/tutorials/beginner/hello_main_event_loop.html)
Introduction to the update loop and how to access it when extending
`SimpleApplication`.

The update loop is encapsulated within the `simpleUpdate(float tpf)` method.
An update is also sometimes referred to as a "tick".
The `tpf` (__time per frame__) parameter is a float which tracks the elapsed time
since the last update.
This allows for smooth rendering which remains independent of the speed of the CPU.

There are generally three phases of every game:
* Init - `simpleInitApp()` is executed once only at the beginning
* Update - `simpleUpdate(float tpf)` is executed continuously during the game
* Render - after every `simpleUpdate`, jMonkeyEngine automatically redraws the screen

This example is naieve in the sense that for more complex applications it would be
best to make use of `AppState` and `Control` classes
(but for now these are out of scope).
