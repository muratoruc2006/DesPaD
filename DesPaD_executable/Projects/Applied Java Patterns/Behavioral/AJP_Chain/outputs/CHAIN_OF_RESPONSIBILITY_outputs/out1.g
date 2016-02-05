// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  3 [label="Class",color=blue,fontcolor=blue];
  5 [label="Class",color=blue,fontcolor=blue];
  8 [label="Interface",color=blue,fontcolor=blue];
  5 -> 8 [label="implements",color=blue,fontcolor=blue];
  3 -> 8 [label="related_with_its_method",color=blue,fontcolor=blue];
  5 -> 8 [label="related_with_its_method",color=blue,fontcolor=blue];
  8 -> 8 [label="has_a_method_with_the_return_type_of",color=blue,fontcolor=blue];
  1 [label="Class",color=black,fontcolor=black];
  2 [label="Interface",color=black,fontcolor=black];
  4 [label="Class",color=black,fontcolor=black];
  6 [label="Class",color=black,fontcolor=black];
  7 [label="Class",color=black,fontcolor=black];
  9 [label="Interface",color=black,fontcolor=black];
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
  23 [label="Class",color=black,fontcolor=black];
  24 [label="Class",color=black,fontcolor=black];
  25 [label="Class",color=black,fontcolor=black];
  26 [label="Class",color=black,fontcolor=black];
  27 [label="Class",color=black,fontcolor=black];
  28 [label="Class",color=black,fontcolor=black];
  1 -> 8 [label="implements",color=black,fontcolor=black];
  2 -> 9 [label="extends",color=black,fontcolor=black];
  4 -> 2 [label="implements",color=black,fontcolor=black];
  8 -> 9 [label="extends",color=black,fontcolor=black];
  1 -> 10 [label="has_the_field_type_of",color=black,fontcolor=black];
  1 -> 2 [label="has_the_field_type_of",color=black,fontcolor=black];
  1 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  1 -> 11 [label="creates_objects_of",color=black,fontcolor=black];
  1 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  1 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 2 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  1 -> 11 [label="has_the_return_type_of",color=black,fontcolor=black];
  1 -> 10 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  1 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  1 -> 2 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  1 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 8 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  1 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  1 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  1 -> 11 [label="calls_method_of",color=black,fontcolor=black];
  1 -> 12 [label="calls_method_of",color=black,fontcolor=black];
  2 -> 10 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  2 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  3 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  3 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  3 -> 14 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  3 -> 15 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 14 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 16 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 17 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 10 [label="has_the_field_type_of",color=black,fontcolor=black];
  4 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  4 -> 10 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  4 -> 4 [label="overrides_methods_of",color=black,fontcolor=black];
  4 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  5 -> 10 [label="has_the_field_type_of",color=black,fontcolor=black];
  5 -> 11 [label="has_the_field_type_of",color=black,fontcolor=black];
  5 -> 11 [label="creates_objects_of",color=black,fontcolor=black];
  5 -> 2 [label="has_the_field_type_of",color=black,fontcolor=black];
  5 -> 8 [label="has_the_field_type_of",color=black,fontcolor=black];
  5 -> 18 [label="has_the_field_type_of",color=black,fontcolor=black];
  5 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  5 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  5 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 2 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  5 -> 18 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 18 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  5 -> 2 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  5 -> 19 [label="calls_method_of",color=black,fontcolor=black];
  5 -> 11 [label="calls_method_of",color=black,fontcolor=black];
  5 -> 10 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 8 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 18 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 5 [label="overrides_methods_of",color=black,fontcolor=black];
  5 -> 12 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 20 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 20 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  6 -> 6 [label="overrides_methods_of",color=black,fontcolor=black];
  6 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  6 -> 14 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 14 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 21 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 14 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 22 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 22 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 23 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 24 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 23 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 25 [label="calls_method_of",color=black,fontcolor=black];
  7 -> 10 [label="has_the_field_type_of",color=black,fontcolor=black];
  7 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  7 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 7 [label="overrides_methods_of",color=black,fontcolor=black];
  7 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 25 [label="calls_method_of",color=black,fontcolor=black];
  7 -> 9 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 9 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  7 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 4 [label="creates_objects_of",color=black,fontcolor=black];
  7 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 1 [label="creates_objects_of",color=black,fontcolor=black];
  7 -> 5 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 5 [label="creates_objects_of",color=black,fontcolor=black];
  7 -> 9 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 26 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 26 [label="creates_objects_of",color=black,fontcolor=black];
  7 -> 27 [label="creates_objects_of",color=black,fontcolor=black];
  7 -> 28 [label="calls_method_of",color=black,fontcolor=black];
  7 -> 27 [label="calls_method_of",color=black,fontcolor=black];
  8 -> 10 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 2 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 11 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 11 [label="related_with_its_method",color=black,fontcolor=black];
}
