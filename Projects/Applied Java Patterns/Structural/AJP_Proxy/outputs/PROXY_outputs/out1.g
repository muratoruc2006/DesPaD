// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  5 [label="Interface",color=blue,fontcolor=blue];
  7 [label="Class",color=blue,fontcolor=blue];
  8 [label="Class",color=blue,fontcolor=blue];
  7 -> 5 [label="implements",color=blue,fontcolor=blue];
  8 -> 5 [label="implements",color=blue,fontcolor=blue];
  8 -> 7 [label="creates_objects_of",color=blue,fontcolor=blue];
  1 [label="Class",color=black,fontcolor=black];
  2 [label="Interface",color=black,fontcolor=black];
  3 [label="Class",color=black,fontcolor=black];
  4 [label="Class",color=black,fontcolor=black];
  6 [label="Class",color=black,fontcolor=black];
  9 [label="Interface",color=black,fontcolor=black];
  2 -> 9 [label="extends",color=black,fontcolor=black];
  3 -> 2 [label="implements",color=black,fontcolor=black];
  1 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  1 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 8 [label="creates_objects_of",color=black,fontcolor=black];
  1 -> 3 [label="creates_objects_of",color=black,fontcolor=black];
  1 -> 3 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  4 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  4 -> 4 [label="overrides_methods_of",color=black,fontcolor=black];
  4 -> 9 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 9 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  4 -> 3 [label="creates_objects_of",color=black,fontcolor=black];
  4 -> 9 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  5 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 2 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  5 -> 2 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  6 -> 6 [label="overrides_methods_of",color=black,fontcolor=black];
  6 -> 9 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 9 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 7 [label="overrides_methods_of",color=black,fontcolor=black];
  7 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 2 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  7 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  7 -> 3 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 2 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 6 [label="calls_method_of",color=black,fontcolor=black];
  8 -> 7 [label="has_the_field_type_of",color=black,fontcolor=black];
  8 -> 7 [label="overrides_methods_of",color=black,fontcolor=black];
  8 -> 7 [label="calls_method_of",color=black,fontcolor=black];
  8 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 2 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  8 -> 3 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 2 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
}
