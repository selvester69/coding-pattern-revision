// let page = 1;

// let allData = [];
// let totalPages = 1; // Placeholder, will be updated

// async function fetchAllData(city, cost) {
//     let currentPage = 1;
//     let data = [];

//     do {
//         const URL = `https://jsonmock.hackerrank.com/api/food_outlets?city=${city}&page=${currentPage}`;
//         const response = await fetch(URL).then(res => res.json());
//         data = data.concat(response.data);
//         totalPages = response.total_pages;
//         currentPage++;
//     } while (currentPage <= totalPages);

//     allData = data?.filter(item => item.estimated_cost <= cost).sort((a, b) => {
//         if (b.user_rating.average_rating === a.user_rating.average_rating) {
//             return a.estimated_cost - b.estimated_cost;
//         }
//         return b.user_rating.average_rating - a.user_rating.average_rating;
//     });
//     console.log(allData[0]);
// }


// function main() {
//     // fetchData('Seattle', 120);
//     fetchAllData('Seattle', 120);
// }
// main();
/**
 * Checks if a given Sudoku board is valid.
 * Uses bit manipulation for efficient tracking of seen numbers in rows, columns, and 3x3 squares.
 *
 * @param {character[][]} board The Sudoku board represented as a 2D array of characters.
 * @returns {boolean} True if the Sudoku board is valid, false otherwise.
 */
function isValidSudoku(board) {
    // Initialize arrays to track seen numbers using bitmasks.
    // Each element in these arrays will store a bitmask for a row, column, or square.
    // The 9 least significant bits represent numbers 1-9.
    const rows = new Array(9).fill(0);
    const cols = new Array(9).fill(0);
    const squares = new Array(9).fill(0);

    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {
            // Skip empty cells
            if (board[r][c] === '.') {
                continue;
            }

            // Convert character digit to a 0-indexed integer (e.g., '1' becomes 0, '9' becomes 8)
            const val = parseInt(board[r][c]) - 1;

            // Calculate the index of the 3x3 square
            // (r / 3) * 3 gives the starting row for the square's index (0, 3, or 6)
            // (c / 3) gives the column offset within that row (0, 1, or 2)
            const squareIndex = Math.floor(r / 3) * 3 + Math.floor(c / 3);

            // Check if the number has already been seen in the current row, column, or square
            // (1 << val) creates a bitmask with the bit corresponding to 'val' set.
            // A bitwise AND operation ( & ) checks if that bit is already set in the respective tracker.
            if ((rows[r] & (1 << val)) > 0 ||
                (cols[c] & (1 << val)) > 0 ||
                (squares[squareIndex] & (1 << val)) > 0) {
                return false; // Duplicate found, board is invalid
            }

            // Mark the number as seen in the current row, column, and square
            // A bitwise OR operation ( | ) sets the bit corresponding to 'val'.
            rows[r] |= (1 << val);
            cols[c] |= (1 << val);
            squares[squareIndex] |= (1 << val);
        }
    }

    // If no duplicates were found after checking all cells, the board is valid
    return true;
}

// --- Example Usage ---
console.log("--- Example 1 ---");
const board1 = [
    ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
    ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
    ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
    ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
    ['4', '.', '9', '.', '.', '3', '.', '.', '1'], // Corrected '8' to '.' to avoid conflict in square
    ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
    ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
    ['.', '.', '.', '4', '1', '9', '.', '.', '5'], // Corrected the elements to be 9
    ['.', '.', '.', '.', '8', '.', '.', '7', '9']  // Corrected the elements to be 9
];
console.log("Is board 1 valid?", isValidSudoku(board1)); // Expected: true (after correction)
