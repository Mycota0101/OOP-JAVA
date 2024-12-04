public class Field {
    private Object[][] field;

    public Field(int rows, int cols) {
        field = new Object[rows][cols];
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public void place(Object obj, Location location) {
        field[location.getRow()][location.getCol()] = obj;
    }

    public Location freeAdjacentLocation(Location location) {
        int row = location.getRow();
        int col = location.getCol();

        if (isValidLocation(row + 1, col)) return new Location(row + 1, col);
        if (isValidLocation(row - 1, col)) return new Location(row - 1, col);
        if (isValidLocation(row, col + 1)) return new Location(row, col + 1);
        if (isValidLocation(row, col - 1)) return new Location(row, col - 1);
        return null;
    }

    private boolean isValidLocation(int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[0].length && field[row][col] == null;
    }

    public void printField() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                Object obj = field[row][col];
                if (obj instanceof Rabbit) {
                    System.out.print("R ");
                } else if (obj instanceof Fox) {
                    System.out.print("F ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
