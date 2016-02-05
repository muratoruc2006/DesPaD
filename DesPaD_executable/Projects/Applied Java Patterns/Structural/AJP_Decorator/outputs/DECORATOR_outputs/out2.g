// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  4 [label="Class",color=blue,fontcolor=blue];
  5 [label="Abstract",color=blue,fontcolor=blue];
  6 [label="Class",color=blue,fontcolor=blue];
  8 [label="Interface",color=blue,fontcolor=blue];
  9 [label="Class",color=blue,fontcolor=blue];
  4 -> 8 [label="implements",color=blue,fontcolor=blue];
  5 -> 8 [label="implements",color=blue,fontcolor=blue];
  6 -> 8 [label="implements",color=blue,fontcolor=blue];
  9 -> 5 [label="extends",color=blue,fontcolor=blue];
  5 -> 8 [label="related_with_its_method",color=blue,fontcolor=blue];
  1 [label="Interface",color=black,fontcolor=black];
  2 [label="Class",color=black,fontcolor=black];
  3 [label="Class",color=black,fontcolor=black];
  7 [label="Class",color=black,fontcolor=black];
  3 -> 1 [label="implements",color=black,fontcolor=black];
  7 -> 5 [label="extends",color=black,fontcolor=black];
  2 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 3 [label="creates_objects_of",color=black,fontcolor=black];
  2 -> 4 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 4 [label="creates_objects_of",color=black,fontcolor=black];
  2 -> 6 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 6 [label="creates_objects_of",color=black,fontcolor=black];
  2 -> 5 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 9 [label="creates_objects_of",color=black,fontcolor=black];
  2 -> 7 [label="creates_objects_of",color=black,fontcolor=black];
  4 -> 1 [label="has_the_field_type_of",color=black,fontcolor=black];
  4 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 1 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  4 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  4 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  5 -> 8 [label="has_the_field_type_of",color=black,fontcolor=black];
  5 -> 8 [label="overrides_methods_of",color=black,fontcolor=black];
  5 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  6 -> 1 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 1 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  6 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  7 -> 8 [label="has_the_field_type_of",color=black,fontcolor=black];
  7 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 8 [label="overrides_methods_of",color=black,fontcolor=black];
}
