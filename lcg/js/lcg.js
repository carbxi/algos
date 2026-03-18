export function lcgBuilder(a, c, m) {
  return function (x) {
    return (a * x + c) % m
  }
}
