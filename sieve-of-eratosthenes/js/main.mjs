const exampleValue = 101; //Primes up to n

export function primes(n) {
  const sqn = Math.sqrt(n); //I should not calculate this
  const primes = Array(n).fill(true);
  primes[0] = false;
  for (let p = 2; p < sqn; p++) {// Instead, if and only if p === true, i should check if p*p<n
    if (primes[p - 1] === true) {
      for (let k = 2 * p; k <= n; k += p) {
        primes[k - 1] = false;
      }
    }
  }
  return primes
}

//Test Loop
if (import.meta.main) {
  const arr = primes(exampleValue);
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === true) {
      console.log(i + 1);
    }
  }
}
