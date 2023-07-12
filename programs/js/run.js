function findSum(arr, key) {
    const map = {};
    for (let elem of arr) {
        map[arr[elem]] = arr[elem];
    }

    for (let elem of arr) {
        if (map[key-elem]){
            return [elem, key-elem];
        }
    }
    return false;
}
console.log(findSum([1,21,3,14,5,60,7,6], 81));