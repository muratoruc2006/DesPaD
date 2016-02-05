// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  5 [label="Class",color=blue,fontcolor=blue];
  6 [label="Abstract",color=blue,fontcolor=blue];
  7 [label="Class",color=blue,fontcolor=blue];
  9 [label="Interface",color=blue,fontcolor=blue];
  5 -> 9 [label="implements",color=blue,fontcolor=blue];
  7 -> 6 [label="extends",color=blue,fontcolor=blue];
  5 -> 7 [label="creates_objects_of",color=blue,fontcolor=blue];
  1 [label="Abstract",color=black,fontcolor=black];
  2 [label="Class",color=black,fontcolor=black];
  3 [label="Class",color=black,fontcolor=black];
  4 [label="Class",color=black,fontcolor=black];
  8 [label="Class",color=black,fontcolor=black];
  10 [label="Class",color=black,fontcolor=black];
  11 [label="Class",color=black,fontcolor=black];
  12 [label="Class",color=black,fontcolor=black];
  13 [label="Class",color=black,fontcolor=black];
  14 [label="Class",color=black,fontcolor=black];
  15 [label="Class",color=black,fontcolor=black];
  16 [label="Class",color=black,fontcolor=black];
  17 [label="Class",color=black,fontcolor=black];
  18 [label="Class",color=black,fontcolor=black];
  19 [label="Class",color=black,fontcolor=black];
  20 [label="Class",color=black,fontcolor=black];
  21 [label="Class",color=black,fontcolor=black];
  22 [label="Class",color=black,fontcolor=black];
  2 -> 1 [label="extends",color=black,fontcolor=black];
  3 -> 9 [label="implements",color=black,fontcolor=black];
  8 -> 6 [label="extends",color=black,fontcolor=black];
  10 -> 1 [label="extends",color=black,fontcolor=black];
  1 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  1 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  1 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  1 -> 11 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  1 -> 12 [label="calls_method_of",color=black,fontcolor=black];
  2 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  2 -> 13 [label="has_the_field_type_of",color=black,fontcolor=black];
  2 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  2 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  2 -> 11 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  2 -> 14 [label="calls_method_of",color=black,fontcolor=black];
  2 -> 15 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 16 [label="has_the_return_type_of",color=black,fontcolor=black];
  3 -> 6 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 6 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  3 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  3 -> 8 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 1 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  3 -> 2 [label="creates_objects_of",color=black,fontcolor=black];
  4 -> 4 [label="overrides_methods_of",color=black,fontcolor=black];
  4 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 11 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  4 -> 9 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 5 [label="creates_objects_of",color=black,fontcolor=black];
  4 -> 6 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 17 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 5 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 18 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 19 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 3 [label="creates_objects_of",color=black,fontcolor=black];
  4 -> 20 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 3 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 21 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 22 [label="calls_method_of",color=black,fontcolor=black];
  5 -> 16 [label="has_the_return_type_of",color=black,fontcolor=black];
  5 -> 6 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 6 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  5 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 1 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 10 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  6 -> 6 [label="overrides_methods_of",color=black,fontcolor=black];
  6 -> 11 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  7 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  7 -> 6 [label="overrides_methods_of",color=black,fontcolor=black];
  8 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  8 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 6 [label="overrides_methods_of",color=black,fontcolor=black];
  9 -> 6 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  9 -> 6 [label="related_with_its_method",color=black,fontcolor=black];
  9 -> 1 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  9 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  10 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  10 -> 13 [label="has_the_field_type_of",color=black,fontcolor=black];
  10 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  10 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  10 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  10 -> 11 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  10 -> 14 [label="calls_method_of",color=black,fontcolor=black];
  10 -> 15 [label="calls_method_of",color=black,fontcolor=black];
}
