---
chapter: ''
title: "Euclid's Algorithm"
tags: ['numbers']
---

<ul>
  <li class="fragment"><div class="deflate">Euclid's theorem: For any numbers <code>a</code>, <code>b</code>, and <code>x</code>: <code>gcd(a,b)=gcd(b,a-bx)</code></div></li>
  <li class="fragment"><div class="deflate">Can be rewritten as:<br><code>gcd(a,b)=gcd(b,a mod b)</code> while <code>b &lt; 0</code></div></li>
  <li class="fragment"><div class="deflate"><em>FAST</em></div></li>
</ul>

{% capture notes %}
* This is stinking fast
* Let's go do it in Clojure
{% endcapture %}
{% include hydeslides/core/notes %}
