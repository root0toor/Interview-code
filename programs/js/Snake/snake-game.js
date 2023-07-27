// Constants
const BOARD_SIZE = 20;
const CELL_SIZE = 20;
const INITIAL_SPEED = 200; // in milliseconds

// Directions
const DIRECTIONS = {
    UP: "up",
    DOWN: "down",
    LEFT: "left",
    RIGHT: "right",
};

// Game Class
class Game {
    constructor() {
        this.board = [];
        this.snake = new Snake();
        this.food = this.generateFood();
        this.direction = DIRECTIONS.RIGHT;
        this.interval = null;
        this.score = 0;
        this.speed = INITIAL_SPEED;
    }

    start() {
        document.addEventListener("keydown", this.handleKeyPress.bind(this));
        this.interval = setInterval(this.update.bind(this), this.speed);
    }

    update() {
        this.moveSnake();
        if (this.checkCollision()) {
            this.endGame();
        } else {
            this.updateBoard();
            this.draw();
        }
    }

    moveSnake() {
        const { row, col } = this.snake.getHead();

        let newRow = row;
        let newCol = col;

        if (this.direction === DIRECTIONS.UP) {
            newRow--;
        } else if (this.direction === DIRECTIONS.DOWN) {
            newRow++;
        } else if (this.direction === DIRECTIONS.LEFT) {
            newCol--;
        } else if (this.direction === DIRECTIONS.RIGHT) {
            newCol++;
        }

        this.snake.move(newRow, newCol);
    }

    checkCollision() {
        const { row, col } = this.snake.getHead();

        // Check collision with walls
        if (
            row < 0 ||
            row >= BOARD_SIZE ||
            col < 0 ||
            col >= BOARD_SIZE
        ) {
            return true;
        }

        // Check collision with self
        if (this.snake.checkCollision(row, col)) {
            return true;
        }

        // Check collision with food
        if (row === this.food.row && col === this.food.col) {
            this.snake.grow();
            this.food = this.generateFood();
            this.score++;
            this.increaseSpeed();
        }

        return false;
    }

    updateBoard() {
        this.board = Array.from({ length: BOARD_SIZE }, () =>
            Array.from({ length: BOARD_SIZE }, () => false)
        );

        const segments = this.snake.getSegments();
        for (const segment of segments) {
            const { row, col } = segment;
            this.board[row][col] = true;
        }

        const { row, col } = this.food;
        this.board[row][col] = true;
    }

    draw() {
        const canvas = document.getElementById("game-canvas");
        const ctx = canvas.getContext("2d");
        ctx.clearRect(0, 0, canvas.width, canvas.height);

        for (let row = 0; row < BOARD_SIZE; row++) {
            for (let col = 0; col < BOARD_SIZE; col++) {
                if (this.board[row][col]) {
                    ctx.fillStyle = "black";
                } else {
                    ctx.fillStyle = "white";
                }

                ctx.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                ctx.strokeStyle = "gray";
                ctx.strokeRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        document.getElementById("score").textContent = this.score;
    }

    handleKeyPress(event) {
        if (event.key === "ArrowUp" && this.direction !== DIRECTIONS.DOWN) {
            this.direction = DIRECTIONS.UP;
        } else if (event.key === "ArrowDown" && this.direction !== DIRECTIONS.UP) {
            this.direction = DIRECTIONS.DOWN;
        } else if (event.key === "ArrowLeft" && this.direction !== DIRECTIONS.RIGHT) {
            this.direction = DIRECTIONS.LEFT;
        } else if (event.key === "ArrowRight" && this.direction !== DIRECTIONS.LEFT) {
            this.direction = DIRECTIONS.RIGHT;
        }
    }

    generateFood() {
        const row = Math.floor(Math.random() * BOARD_SIZE);
        const col = Math.floor(Math.random() * BOARD_SIZE);
        return { row, col };
    }

    increaseSpeed() {
        if (this.speed > 50) {
            this.speed -= 10;
            clearInterval(this.interval);
            this.interval = setInterval(this.update.bind(this), this.speed);
        }
    }

    endGame() {
        clearInterval(this.interval);
        alert("Game Over! Your score: " + this.score);
    }
}

// Snake Class
class Snake {
    constructor() {
        this.segments = [
            { row: 10, col: 10 },
            { row: 10, col: 9 },
            { row: 10, col: 8 },
        ];
    }

    getSegments() {
        return this.segments;
    }

    getHead() {
        return this.segments[0];
    }

    move(row, col) {
        this.segments.unshift({ row, col });
        this.segments.pop();
    }

    grow() {
        const { row, col } = this.segments[0];
        this.segments.unshift({ row, col });
    }

    checkCollision(row, col) {
        for (let i = 1; i < this.segments.length; i++) {
            if (this.segments[i].row === row && this.segments[i].col === col) {
                return true;
            }
        }
        return false;
    }
}

// Initialize and start the game
const game = new Game();
game.start();
