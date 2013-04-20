---
chapter: ''
title: 'Integer Partitioning'
tags: ['counting']
---

<ul>
  <li class="fragment"><div class="deflate">Imagine <code>n</code> identical goodie bags and <code>k</code> identical Octocat stickers</div></li>
  <li class="fragment"><div class="deflate">Distribute stickers with no regard for fairness</div></li>
  <li class="fragment"><div class="deflate">You have <code>p<sub>k</sub>(n)</code> options</div></li>
  <li class="fragment"><div class="deflate">Only defined recursively:<br>
    <code>p<sub>k</sub>(n) = p<sub>k-1</sub>(n-1)+p<sub>k</sub>(n-k)</code><br>
    <code>p<sub>0</sub>(n) = 0</code><br>
    <code>p<sub>1</sub>(n) = 1</code><br>
    <code>p<sub>k</sub>(1) = 1</code><br>
    <code>p<sub>k</sub>(n ≤ 0) = 0</code></div></li>
</ul>


{% capture notes %}
* How many ways can you express n as the sum of k integers?
{% endcapture %}
{% include hydeslides/core/notes %}
