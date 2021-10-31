package stack;

import java.util.Arrays;
import java.util.Random;

public class Maze {
    Cell entrance;
    Cell export;
    Cell move;
    Cell[][] mazes;

    public Maze(int size) {
        mazes = new Cell[size][size];
        entrance = new Cell(0, 0, true);
        export = new Cell(size - 1, size - 1, true);
        Random random = new Random();
        boolean isAdopt;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) {
                    mazes[0][0] = entrance;
                    continue;
                }
                if (i == size - 1 && j == size - 1) {
                    mazes[size - 1][size - 1] = export;
                    continue;
                }
                isAdopt = random.nextBoolean();
                mazes[i][j] = new Cell(i, j, isAdopt);
            }
        }
    }

    public void play() {
        Stack<Cell> stack = new SeqStack<>();
        move = entrance;
        while (!move.equals(export)) {
            while (move.isAdopt == true) {
                stack.push(move);
                move = mazes[move.x][move.y + 1];
            }
            move = stack.pop();
            while (move.isAdopt == true) {
                stack.push(move);
                move = mazes[move.x + 1][move.y];
            }
            move = stack.pop();
            while (move.isAdopt == true) {
                stack.push(move);
                move = mazes[move.x][move.y - 1];
            }
            move = stack.pop();
            while (move.isAdopt == true) {
                move = stack.pop();
                move = mazes[move.x - 1][move.y];
            }
        }
        System.out.println(stack.toString());
    }

    public static void main(String[] args) {
        Maze maze = new Maze(6);
        for (Cell[] cell : maze.mazes) {
            System.out.println(Arrays.toString(cell));
        }
        maze.play();
    }
}
