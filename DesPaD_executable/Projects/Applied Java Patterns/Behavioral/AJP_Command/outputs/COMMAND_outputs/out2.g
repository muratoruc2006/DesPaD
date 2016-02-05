// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  1 [label="Class",color=blue,fontcolor=blue];
  3 [label="Class",color=blue,fontcolor=blue];
  5 [label="Interface",color=blue,fontcolor=blue];
  8 [label="Class",color=blue,fontcolor=blue];
  16 [label="Class",color=blue,fontcolor=blue];
  1 -> 5 [label="implements",color=blue,fontcolor=blue];
  1 -> 16 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=blue,fontcolor=blue];
  3 -> 16 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=blue,fontcolor=blue];
  8 -> 5 [label="related_with_its_method",color=blue,fontcolor=blue];
  2 [label="Interface",color=black,fontcolor=black];
  4 [label="Class",color=black,fontcolor=black];
  6 [label="Class",color=black,fontcolor=black];
  7 [label="Class",color=black,fontcolor=black];
  9 [label="Interface",color=black,fontcolor=black];
  10 [label="Interface",color=black,fontcolor=black];
  11 [label="Interface",color=black,fontcolor=black];
  12 [label="Class",color=black,fontcolor=black];
  13 [label="Interface",color=black,fontcolor=black];
  14 [label="Interface",color=black,fontcolor=black];
  15 [label="Class",color=black,fontcolor=black];
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
  29 [label="Class",color=black,fontcolor=black];
  30 [label="Class",color=black,fontcolor=black];
  31 [label="Class",color=black,fontcolor=black];
  32 [label="Class",color=black,fontcolor=black];
  33 [label="Class",color=black,fontcolor=black];
  34 [label="Class",color=black,fontcolor=black];
  35 [label="Class",color=black,fontcolor=black];
  36 [label="Class",color=black,fontcolor=black];
  37 [label="Class",color=black,fontcolor=black];
  38 [label="Class",color=black,fontcolor=black];
  39 [label="Class",color=black,fontcolor=black];
  40 [label="Class",color=black,fontcolor=black];
  41 [label="Class",color=black,fontcolor=black];
  42 [label="Class",color=black,fontcolor=black];
  43 [label="Class",color=black,fontcolor=black];
  44 [label="Class",color=black,fontcolor=black];
  45 [label="Class",color=black,fontcolor=black];
  46 [label="Class",color=black,fontcolor=black];
  47 [label="Class",color=black,fontcolor=black];
  48 [label="Class",color=black,fontcolor=black];
  49 [label="Class",color=black,fontcolor=black];
  2 -> 13 [label="extends",color=black,fontcolor=black];
  4 -> 2 [label="implements",color=black,fontcolor=black];
  5 -> 13 [label="extends",color=black,fontcolor=black];
  6 -> 14 [label="implements",color=black,fontcolor=black];
  6 -> 9 [label="implements",color=black,fontcolor=black];
  7 -> 15 [label="extends",color=black,fontcolor=black];
  10 -> 11 [label="extends",color=black,fontcolor=black];
  12 -> 10 [label="implements",color=black,fontcolor=black];
  1 -> 16 [label="has_the_field_type_of",color=black,fontcolor=black];
  1 -> 16 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 16 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  1 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  2 -> 16 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  2 -> 16 [label="related_with_its_method",color=black,fontcolor=black];
  2 -> 16 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  3 -> 18 [label="has_the_field_type_of",color=black,fontcolor=black];
  3 -> 18 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 3 [label="overrides_methods_of",color=black,fontcolor=black];
  3 -> 16 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 4 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 8 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 1 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 12 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 12 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 19 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 12 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 6 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 6 [label="creates_objects_of",color=black,fontcolor=black];
  3 -> 20 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 6 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 21 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 21 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  3 -> 22 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 22 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  3 -> 23 [label="calls_method_of",color=black,fontcolor=black];
  4 -> 16 [label="has_the_field_type_of",color=black,fontcolor=black];
  4 -> 16 [label="related_with_its_method",color=black,fontcolor=black];
  4 -> 16 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  4 -> 16 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  4 -> 4 [label="overrides_methods_of",color=black,fontcolor=black];
  4 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  5 -> 16 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  5 -> 16 [label="related_with_its_method",color=black,fontcolor=black];
  5 -> 16 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  6 -> 24 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 25 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 26 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 27 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 28 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 10 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 8 [label="has_the_field_type_of",color=black,fontcolor=black];
  6 -> 10 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 10 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  6 -> 6 [label="overrides_methods_of",color=black,fontcolor=black];
  6 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  6 -> 24 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 29 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 30 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 24 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 31 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 28 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 32 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 26 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 33 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 26 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 34 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 25 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 35 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 25 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 36 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 27 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 37 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 27 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 38 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 39 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 40 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 41 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 7 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 7 [label="calls_method_of",color=black,fontcolor=black];
  6 -> 42 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 42 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  6 -> 43 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 44 [label="calls_method_of",color=black,fontcolor=black];
  7 -> 7 [label="overrides_methods_of",color=black,fontcolor=black];
  7 -> 45 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 45 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  7 -> 5 [label="related_with_its_method",color=black,fontcolor=black];
  7 -> 5 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  7 -> 1 [label="creates_objects_of",color=black,fontcolor=black];
  7 -> 46 [label="calls_method_of",color=black,fontcolor=black];
  7 -> 1 [label="calls_method_of",color=black,fontcolor=black];
  7 -> 47 [label="calls_method_of",color=black,fontcolor=black];
  7 -> 48 [label="calls_method_of",color=black,fontcolor=black];
  8 -> 16 [label="has_the_field_type_of",color=black,fontcolor=black];
  8 -> 2 [label="has_the_field_type_of",color=black,fontcolor=black];
  8 -> 5 [label="has_the_field_type_of",color=black,fontcolor=black];
  8 -> 21 [label="has_the_field_type_of",color=black,fontcolor=black];
  8 -> 16 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 16 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  8 -> 2 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 2 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  8 -> 5 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  8 -> 21 [label="related_with_its_method",color=black,fontcolor=black];
  8 -> 21 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  8 -> 16 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 8 [label="overrides_methods_of",color=black,fontcolor=black];
  8 -> 2 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 5 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  8 -> 1 [label="overrides_methods_of",color=black,fontcolor=black];
  8 -> 21 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  9 -> 5 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  9 -> 5 [label="related_with_its_method",color=black,fontcolor=black];
  12 -> 8 [label="has_the_field_type_of",color=black,fontcolor=black];
  12 -> 5 [label="has_the_field_type_of",color=black,fontcolor=black];
  12 -> 9 [label="has_the_field_type_of",color=black,fontcolor=black];
  12 -> 8 [label="related_with_its_method",color=black,fontcolor=black];
  12 -> 8 [label="has_a_method_with_the_return_type_of",color=black,fontcolor=black];
  12 -> 12 [label="overrides_methods_of",color=black,fontcolor=black];
  12 -> 6 [label="overrides_methods_of",color=black,fontcolor=black];
  12 -> 8 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  12 -> 9 [label="related_with_its_method",color=black,fontcolor=black];
  12 -> 9 [label="has_a_method_that_has_an_input_parameter_with_the_type_of",color=black,fontcolor=black];
  12 -> 48 [label="calls_method_of",color=black,fontcolor=black];
  12 -> 49 [label="calls_method_of",color=black,fontcolor=black];
}
