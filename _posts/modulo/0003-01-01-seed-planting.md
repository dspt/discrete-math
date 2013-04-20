---
chapter: ''
title: 'Seed Planting'
tags: ['modulo']
---

<ul>
  <li class="fragment"><div class="deflate">Let's calculate <code>7<sup>103</sup></code></div></li>
  <li class="fragment"><div class="deflate">103 multiplications is too expensive!</div></li>
  <li class="fragment"><div class="deflate"><code>103</code> in binary is <code>1100111</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>1*7</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>7<sup>2</sup>*7=343</code></div></li>
  <li class="fragment"><div class="deflate"><code>0</code>: <code>343<sup>2</sup>=117649</code></div></li>
  <li class="fragment"><div class="deflate"><code>0</code>: <code>117649<sup>2</sup>=13841287201</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>13841287201<sup>2</sup>*7=1341068619663964900807</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>1341068619663964900807<sup>2</sup>*7=12589255298531885026341962383987545444758743</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>12589255298531885026341962383987545444758743<sup>2</sup>*7=1109425442801291991031214184801374366124020697224286512520326098667350170655466324580343</code></div></li>
</ul>


{% capture notes %}

{% endcapture %}
{% include hydeslides/core/notes %}
