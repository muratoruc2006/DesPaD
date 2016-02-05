// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  2 [label="Class",color=blue,fontcolor=blue];
  4 [label="Abstract",color=blue,fontcolor=blue];
  2 -> 4 [label="extends",color=blue,fontcolor=blue];
  2 -> 4 [label="overrides_methods_of",color=blue,fontcolor=blue];
  1 [label="Class",color=black,fontcolor=black];
  3 [label="Class",color=black,fontcolor=black];
  3 -> 4 [label="extends",color=black,fontcolor=black];
  1 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 2 [label="creates_objects_of",color=black,fontcolor=black];
  1 -> 3 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 3 [label="creates_objects_of",color=black,fontcolor=black];
  2 -> 4 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 4 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  3 -> 4 [label="overrides_methods_of",color=black,fontcolor=black];
}
