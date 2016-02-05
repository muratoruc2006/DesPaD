// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  3 [label="Class",color=blue,fontcolor=blue];
  5 [label="Class",color=blue,fontcolor=blue];
  7 [label="Class",color=blue,fontcolor=blue];
  9 [label="Interface",color=blue,fontcolor=blue];
  10 [label="Class",color=blue,fontcolor=blue];
  5 -> 9 [label="implements",color=blue,fontcolor=blue];
  7 -> 9 [label="implements",color=blue,fontcolor=blue];
  3 -> 10 [label="calls_method_of",color=blue,fontcolor=blue];
  10 -> 9 [label="has_the_field_type_of",color=blue,fontcolor=blue];
  1 [label="Class",color=black,fontcolor=black];
  2 [label="Interface",color=black,fontcolor=black];
  4 [label="Class",color=black,fontcolor=black];
  6 [label="Interface",color=black,fontcolor=black];
  8 [label="Class",color=black,fontcolor=black];
  4 -> 2 [label="implements",color=black,fontcolor=black];
  8 -> 6 [label="implements",color=black,fontcolor=black];
  3 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 1 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 1 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 4 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 8 [label="creates_objects_of",color=black,fontcolor=black];
  10 -> 7 [label="creates_objects_of",color=black,fontcolor=black];
  10 -> 5 [label="creates_objects_of",color=black,fontcolor=black];
  10 -> 5 [label="has_the_return_type_of",color=black,fontcolor=black];
  10 -> 9 [label="related_with_its_method",color=black,fontcolor=black];
  10 -> 9 [label="overrides_methods_of",color=black,fontcolor=black];
  10 -> 9 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
}
