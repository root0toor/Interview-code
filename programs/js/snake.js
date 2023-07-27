class Board {
    board = [];
    // snake = [[0,0]];
    initializeBoard = (n) => {
        this.board = [];
        for (var i = 0; i < n; i++) {
            this.board[i] = [];
            for (var j = 0; j < n; j++) {
                this.board[i][j] = 0;
            }
        }
        // console.log(this.board);
    }

    getBoard = () => {
        return this.board;
    }
    50100183408481
    initializeSnake = () => {
        this.board[0][0] = 'X';
        // const snake = new Snake();
    }
}

class Snake {
    points = [[0, 0]];
    moveSnake = (dir, arr) => {
        if(dir == "R"){
            arr[]
        }
    }

    getPoints = () => {
        return this.points;
    }

    indexOutOfBounds = (row, col, n) => {
        if (row >= n && col >= n && row < 0 && col < 0) {
            return true;
        }
        return false;
    }

    hitsitself = (row, col, arr) => {
        if (arr[row] != 'X' && arr[col] != 'X') {
            return true;
        }
        return false;
    }

    gameOver = (arr, row, col) => {
        return indexOutOfBounds(targetRow, targetCol, arr.length) && hitsitself(targetRow, targetCol, arr);
    }
}

// class Game {


// }

var input = ["R", "R", "R", "R"];

var startGame = () => {
    const board = new Board();
    // console.log(board);
    board.initializeBoard(10);
    board.initializeSnake();
    
    const snake = new Snake();
    snake.moveSnake("R");
    // console.log(board.getBoard());
}

startGame();

// (i ,j) => [x, x, x]

// [
//     [0, 0, 0, 0],
//     [x, x, x, 0],
//     [0, x, x, 0],
//     [0, 0, 0, 0],
// ]

// [(1,1),(1,2),(1,3)]