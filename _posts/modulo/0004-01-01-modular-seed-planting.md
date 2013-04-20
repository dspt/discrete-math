---
chapter: ''
title: 'Modular Seed Planting'
tags: ['modulo']
---

<ul>
  <li class="fragment"><div class="deflate">Let's calculate <code>7<sup>103</sup> mod 53</code></div></li>
  <li class="fragment"><div class="deflate">Those numbers got too big!</div></li>
  <li class="fragment"><div class="deflate"><code>103</code> in binary is <code>1100111</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>1*7 mod 53 = 7</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>7<sup>2</sup>*7 mod 53 = 25</code></div></li>
  <li class="fragment"><div class="deflate"><code>0</code>: <code>25<sup>2</sup> mod 53 = 42</code></div></li>
  <li class="fragment"><div class="deflate"><code>0</code>: <code>42<sup>2</sup> mod 53 = 15</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>15<sup>2</sup>*7 mod 53 = 38</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>38<sup>2</sup>*7 mod 53 = 38</code></div></li>
  <li class="fragment"><div class="deflate"><code>1</code>: <code>38<sup>2</sup>*7 mod 53 = 38</code></div></li>
</ul>


{% capture notes %}
* This is fast, the numbers stay small, and it's gonna come in handy for PKI
{% endcapture %}
{% include hydeslides/core/notes %}
