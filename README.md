### Overview
Inspired by skill trees and leveling systems in video games, I've often wondered why there haven't been programs built for tracking your real life status in a similar way. This project is an attempt to bring that concept to fruition.

### TODO List
- [X] Doubly Linked Tree (Underlying Data Structure)
- [X] Command Line Interface
- [ ] GUI Interface
- [ ] Serializing Data (Probably With JSON)  
- [ ] Standalone Program
- [ ] WebApp?

* * *

### Current Status
So far, I've gotten the underlying data structure roughly created, I might change how the relationship between children and parents acts, but for now it works. I think for now, I'll be working on adding the serilalization with some generic package, so then my work with GUI and command line won't be needlessly repetitive.

Example Printout From Current Version: 
```
Comp Sci [62%]
├── Data Structures [59%]
│   ├── Lists [97%]
│   ├── Graphs [32%]
│   └── Trees [49%]
└── Algorithms [65%]
    ├── Sorting [53%]
    └── Recursion [77%]
```
