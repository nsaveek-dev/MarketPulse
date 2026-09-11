import Foundation

enum StockFormatter {
    static func formatPrice(_ price: Double) -> String {
        let rounded = (price * 100).rounded() / 100
        return String(rounded)
    }

    static func formatChange(_ change: Double) -> String {
        let rounded = (change * 100).rounded() / 100
        return rounded > 0 ? "+\(rounded)" : String(rounded)
    }

    static func formatChangePercent(_ changePercent: String) -> String {
        var normalized = changePercent.trimmingCharacters(in: .whitespaces)
        if normalized.hasSuffix("%") {
            normalized = String(normalized.dropLast())
        }
        guard let value = Double(normalized) else {
            return changePercent.trimmingCharacters(in: .whitespaces).isEmpty ? "-" : changePercent
        }
        let magnitude = String(format: "%.2f", abs(value))
        switch value {
        case let v where v > 0: return "+\(magnitude)%"
        case let v where v < 0: return "-\(magnitude)%"
        default: return "0.00%"
        }
    }
}
