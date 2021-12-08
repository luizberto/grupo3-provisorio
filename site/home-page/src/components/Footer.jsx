import React from "react";

function Footer() {
	return (
		<>
			<footer class="footer-distributed">

				<div class="footer-left">

					<h3>Sport.Fy</h3>

					<p class="footer-links">
						<a href="#" class="link-1">Home</a>

						<a href="#">Blog</a>

						<a href="#">Sobre</a>

						<a href="#">Faq</a>

					</p>

					<p class="footer-company-name">Sport.Fy © 2021</p>
				</div>

				<div class="footer-center">

					<div>
						<i class="fa fa-map-marker"></i>

					</div>

					<div>
						<i class="fa fa-phone"></i>
						<p>(00)0000-0000</p>
					</div>

					<div>
						<i class="fa fa-envelope"></i>
						<p><a href="mailto:support@company.com">sportfy@gmail.com</a></p>
					</div>

				</div>

				<div class="footer-right">

					<p class="footer-company-about">
						<span>Sobre nós</span>
						Criada em 2021 temos o propósito de unir pessoas ao esporte e a tecnologia.
					</p>

					<div class="footer-icons">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-linkedin"></i></a>
						<a href="#"><i class="fa fa-github"></i></a>

					</div>

				</div>

			</footer>
		</>
	);
}
export default Footer;