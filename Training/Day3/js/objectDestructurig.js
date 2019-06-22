let toybox = {item1 : "car", item2 : "ball", item3 : "frisbase"}

let{item1, item2} = toybox;
let {item3 : disc} = toybox

console.log(item1,item2);
console.log(disc);

let widgets = ['widget1','widget2','widget3','widget4','widget5','widget6','widget7']
let [a,b,c,...d] = widgets; // ...d resembles the rest operator.

console.log(a);
console.log(b);
console.log(c);
console.log(d);