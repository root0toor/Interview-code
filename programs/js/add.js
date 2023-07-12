// Returns sum of two numbers
// String add(String a, String b);

const getValueFromIndex = (index, arr) => {
    return index >= 0 ? Number(arr[index]) : 0;
}

const add = (a, b) => {
    const arr1 = a.replace(",", "").split("");
    const arr2 = b.replace(",", "").split("");
    let a1 = arr1.length - 1;
    let a2 = arr2.length - 1;
    let index = Math.min(a1, a2);
    const arr3 = new Array();
    let carry = 0;
    while(a1>= 0 || a2 >= 0) {
        // console.log(index, arr3);
        const sum = getValueFromIndex(a1, arr1) + getValueFromIndex(a2, arr2) + carry;
        const value = sum % 10;
        carry = Math.floor(sum / 10);
        arr3.unshift(value);
        a1--;
        a2--;
    }
    if(carry){
        arr3.unshift(carry);
    }
    // arr3.unshift(currency);
    console.log("       SUM IS          ", Number(arr3.join("")));
};

add("0000100000000000000", "00000000000001");
console.log(Number("0000100000000000000") + Number("00000000000001"));