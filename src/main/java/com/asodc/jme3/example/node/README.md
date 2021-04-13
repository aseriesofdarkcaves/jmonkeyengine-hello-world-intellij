# [HelloNode](https://wiki.jmonkeyengine.org/docs/3.3/tutorials/beginner/hello_node.html)
A **Spatial** contains the location, rotation and scale of an object and can be
loaded, transformed and saved. There are two types of Spatial - a Geometry and
a Node.

In terms of Java, both __Geometry and Node extend Spatial__. 

A **Geometry** is a visible scene object and contains the data about how an object
looks.

A **Node** is an invisible "handle" for scene objects and can be used to group
Geometries and Nodes together.

The general idea for adding an object to the scene is:
* create a Mesh
* wrap the mesh to a Geometry
* add the Geometry to the (root) Node