package main
import "fmt"

func main() {
 //Enter your code here. Read input from STDIN. Print output to STDOUT
    
    // Iterate over candles
    // Everytime a candle of height max is found, increment count
    // If new max is found, set count to one
    var numCandles int
    fmt.Scan(&numCandles)
    
    candleHeights, _ := read(numCandles)
    
    maxHeight := candleHeights[0]
    candlesBlown := 0
    
    for cIndex := range candleHeights {
        cHeight := candleHeights[cIndex]
        
        // check if cHeight == to maxHeight
        if(cHeight == maxHeight) {
            candlesBlown++
        } else if(cHeight > maxHeight) {
            maxHeight = cHeight
            candlesBlown = 1
        }
    }
    
    fmt.Println(candlesBlown)
}

// Referenced from (http://stackoverflow.com/questions/15413469/how-to-make-fmt-scanln-read-into-a-slice-of-integers)
func read(n int) ([]int, error) {
    vals := make([]int, n)
    for index := range vals {
        _, err := fmt.Scan(&vals[index])
        if(err != nil) {
            return vals[:index], err
        }
    }
    return vals, nil
}