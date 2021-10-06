package com.anish.calabashbros;


public class Matrix<T extends Thing> {
    
    private Position<T>[][] positions;
    int row, col;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.positions = new Position[row][col];
    }

    public void put(T element, int i, int j) {
        if (this.positions[i][j] == null) {
            this.positions[i][j] = new Position<T>(null);
        }
        this.positions[i][j].setElement(element);
    }

    public T get(int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col) 
            return null;
        return positions[i][j].element;
    }

    @Override
    public String toString() {
        String matrixString = "";
        // TODO: implement toString()
        return matrixString;
    }

    public T[] toArray() {
        // TODO: create array of T
        T[] elements = new T[row * col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) 
                elements[i * col + j] = positions[i][j].element;
        }

        return elements;
    }



    class Position<T extends Thing> {
        private T element;

        Position(T element) {
            this.element = element;
        }

        public void setElement(T element) {
            this.element = element;
            // TODO: implement set position in Thing
            //element.setPosition(this);
        }
    }
    
}
