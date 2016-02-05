// Subdue 5.2.2 graph in dot format

digraph SubdueGraph {
  3 [label="Class",color=blue,fontcolor=blue];
  4 [label="Class",color=blue,fontcolor=blue];
  5 [label="Interface",color=blue,fontcolor=blue];
  7 [label="Interface",color=blue,fontcolor=blue];
  3 -> 5 [label="implements",color=blue,fontcolor=blue];
  4 -> 7 [label="implements",color=blue,fontcolor=blue];
  3 -> 4 [label="creates_objects_of",color=blue,fontcolor=blue];
  1 [label="Class",color=black,fontcolor=black];
  2 [label="Class",color=black,fontcolor=black];
  6 [label="Class",color=black,fontcolor=black];
  1 -> 7 [label="has_the_field_type_of",color=black,fontcolor=black];
  1 -> 7 [label="related_with_its_method",color=black,fontcolor=black];
  1 -> 2 [label="creates_objects_of",color=black,fontcolor=black];
  2 -> 2 [label="calls_method_of",color=black,fontcolor=black];
  3 -> 7 [label="related_with_its_method",color=black,fontcolor=black];
  3 -> 7 [label="overrides_methods_of",color=black,fontcolor=black];
  6 -> 3 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 3 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 1 [label="related_with_its_method",color=black,fontcolor=black];
  6 -> 1 [label="creates_objects_of",color=black,fontcolor=black];
  6 -> 1 [label="calls_method_of",color=black,fontcolor=black];
}
