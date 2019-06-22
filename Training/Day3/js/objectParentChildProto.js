const parent = {
    name: "Vijay",
    age: 46,
    native: "chennai"
};

const child = Object.create(parent)
child.name = "Ajith"
child.age = "20"

console.log(child.name);
console.log(child.age);
console.log(child.native)