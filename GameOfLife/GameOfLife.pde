int size = 5;
boolean[] cells;
int cellsPerRow;

void setup() {
  size(801, 801);
  background(0, 0, 0);
  stroke(0, 0, 0);
  
  cells = new boolean[round(pow((width - 1) / size, 2))];
  cellsPerRow = round(sqrt(cells.length));
  
  for (int i = 0; i < round(cells.length / 5); i++) {
    int cell = floor(random(cells.length));
    cells[cell] = true;
  }
  
  frameRate(1);
}

void draw() {
  for (int i = 0; i < cells.length; i++) {
    if (cells[i]) {
      fill(125, 255, 125); 
    }
    rect(size * (i % cellsPerRow), size * (i / cellsPerRow), size, size);
    fill(0, 0, 0);
  }
  //update
  boolean[] next = new boolean[cells.length];
  for (int i = 0; i < cells.length; i++) {
    int neighbors = 0;
    for (int rowOffset = -1 ; rowOffset <= 1; rowOffset++) {
      for (int colOffset = -1; colOffset <= 1; colOffset++) {
        if (rowOffset != 0 || colOffset != 0) {
           int index = (rowOffset * cellsPerRow) + colOffset + i;
           if (index >= 0 && index < next.length) {
             neighbors += cells[index] ? 1 : 0; 
           }
        }
      }
    }
    if (cells[i]) {
      next[i] = neighbors == 2 || neighbors == 3;
    } else {
      next[i] = neighbors == 3;
    }
  }
  cells = next;
}